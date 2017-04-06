# Copyright (C) 2016 - 2017 Randy Li <ayaka@soulik.info>
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)

DEFAULT_PREFERENCE = "-1"

include gstreamer1.0-rockchip.inc

SRCBRANCH ?= "develop"
SRC_URI = " \
    git://git.sumomo.pri/gstreamer/gstreamer-rockchip.git;branch=${SRCBRANCH};protocol=ssh \
    git://git.sumomo.pri/gstreamer/common.git;destsuffix=git/common;protocol=ssh;branch=master;name=common \
"

SRCREV_FORMAT = "git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"
