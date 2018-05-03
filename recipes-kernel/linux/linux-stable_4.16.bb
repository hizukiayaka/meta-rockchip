FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.7"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "9dc30ff9a115559cc55673d0b1d3c576402d073e"

require linux-stable.inc
