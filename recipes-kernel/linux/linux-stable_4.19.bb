FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.19.6"
KBRANCH ?= "linux-4.19.y"
SRCREV ?= "96db90800c06d3fe3fa08eb6222fe201286bb778"

require linux-stable.inc
