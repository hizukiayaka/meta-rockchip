require rockchip-mali.inc

SRC_URI = "git://github.com/hizukiayaka/rockchip-mali.git;branch=rockchip-new;"
SRCREV_pn-${PN} = "${AUTOREV}"

COMPATIBLE_MACHINE = "(rk3036|rk3288|rk3326|rk3328|rk3399)"

S = "${WORKDIR}/git"
