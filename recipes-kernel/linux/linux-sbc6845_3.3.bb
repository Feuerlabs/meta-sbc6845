DESCRIPTION = "SBC6845 patched 3.3 kernel."
SECTION = "kernel"
LICENSE = "GPLv2"


LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

SRC_URI = "file://linux-sbc6845-${PV}.tgz;name=kernel"
SRC_URI += "file://defconfig"
SRC_URI[kernel.md5sum] = "98a6cdd7d082b7ea72df9c89842bac74"
