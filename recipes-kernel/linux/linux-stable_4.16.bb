FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.6"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "22bc2b8a6aa4f3c42ff243b1528afd498c8150b1"

require linux-stable.inc
