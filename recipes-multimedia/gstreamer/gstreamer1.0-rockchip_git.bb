# Copyright (C) 2016 - 2017 Randy Li <ayaka@soulik.info>
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)

DEFAULT_PREFERENCE = "-1"

include gstreamer1.0-rockchip.inc

SRCBRANCH ?= "develop"
SRC_URI = " \
    git://github.com/rockchip-linux/gstreamer-rockchip.git;branch=${SRCBRANCH} \
    git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common \
"

SRCREV_FORMAT = "git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
