FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.2"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "216f33936eaa006a8b4f5bb992592e34f6432fc2"

require linux-stable.inc
