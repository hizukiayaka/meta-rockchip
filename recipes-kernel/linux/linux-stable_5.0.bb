FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.0.9"
KBRANCH ?= "linux-5.0.y"
SRCREV ?= "e4abcebedac3415cf347e95749209a4a7b6f3074"

require linux-stable.inc
