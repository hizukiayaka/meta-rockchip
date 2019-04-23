FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.19.36"
KBRANCH ?= "linux-4.19.y"
SRCREV ?= "c98875d930e915d01e8c40c7d3c16f00b3c8abe1"

require linux-stable.inc
