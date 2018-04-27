FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.5"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "e5ce9f6879d3fe20435f34dfd86fb76c36072916"

require linux-stable.inc
