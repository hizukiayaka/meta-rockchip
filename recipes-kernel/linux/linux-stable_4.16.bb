FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.14"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "03329bc68158916821391b5857f1d106ecbe9668"

require linux-stable.inc
