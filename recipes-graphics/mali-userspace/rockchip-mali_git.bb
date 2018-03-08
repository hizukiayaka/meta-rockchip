require rockchip-mali.inc

SRC_URI = "git://git.sumomo.pri/rock-chips/mali-binary.git;protocol=ssh;branch=rockchip-new;"
SRCREV_pn-${PN} = "${AUTOREV}"

COMPATIBLE_MACHINE = "(rk3036|rk3288|rk3326|rk3328|rk3399)"

S = "${WORKDIR}/git"
