FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.15"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "9f8fb09b3e56c6953acf4d18f4b0681b9fc72ae5"

require linux-stable.inc
