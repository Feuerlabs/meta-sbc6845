meta-sbc6845
============

Adds Yocto support for the Embest SBC6845 board.

See meta-exosense for complete build instructions.

# Image Flash Instructions for the SBC6845

Setup a serial connection to the SBC6845 debug DB9 port. 115200 8N1

Power on the SBC6845.

Interrupt the boot process by pressing space immediately after power on

Connect an ethernet cable and setup the device IP address and boot params

    setenv ipaddr 192.168.0.2      # Device IP
    setenv netmask 255.255.255.0
    setenv serverip 192.168.13.45  # TFTP server ip
    setenv bootargs=console=ttySAC6,115200 ubi.mtd=2 root=ubi0:sbc6845-rootfs rootfstype=ubifs
    setenv bootcmd=nand read.i 0x72000000 0x00000000 0x260000; bootm
    saveenv

Note: The third bootcmd read size parameter, 0x260000, may need to be adjusted upward
to be equal to or greater than the loaded uImage file size. See the result of the tftp command used
to retrieve uImage to see the minimum read size parameter value.

Wipe the entire nand area

    nand erase

Load and flash the ubi volume image with the rootfs ubifs

    tftp 0x70000000 core-image-minimal-sbc6845.ubi
    nand write.i 0x70000000 0xba0000 $(filesize)

Load the boot uImage

    tftp 0x72000000 uImage
    nand write.i 0x72000000 0x0 $(filesize)


Boot the image

    boot
