FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.17.3"
KBRANCH ?= "linux-4.17.y"
SRCREV ?= "83e05c58300605f3ab87819c19d1822f54eff81e"

require linux-stable.inc
