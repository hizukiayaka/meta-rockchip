FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.8"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "dec316ea18281d2892324a4bfeb4d5a8a6605e69"

require linux-stable.inc
