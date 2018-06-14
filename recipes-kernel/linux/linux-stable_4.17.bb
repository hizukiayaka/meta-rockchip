FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.17.1"
KBRANCH ?= "linux-4.17.y"
SRCREV ?= "d0c077266ecbe4ebbaac24c0fe5bd81c5304c5a2"

require linux-stable.inc
