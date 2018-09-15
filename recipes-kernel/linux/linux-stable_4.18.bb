FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.18.8"
KBRANCH ?= "linux-4.18.y"
SRCREV ?= "dfba61ec760efc578a3f3702e752b51ca1dfed52"

require linux-stable.inc
