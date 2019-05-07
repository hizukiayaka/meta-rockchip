FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.0.13"
KBRANCH ?= "linux-5.0.y"
SRCREV ?= "e5b9547b1aa39164a8df1d01f2996391c0356d71"

require linux-stable.inc
