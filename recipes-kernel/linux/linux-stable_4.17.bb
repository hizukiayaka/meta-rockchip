FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.17.19"
KBRANCH ?= "linux-4.17.y"
SRCREV ?= "62134e7b2b7993aff369a2f64f5b39634ac7f7c9"

require linux-stable.inc
