FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.17.11"
KBRANCH ?= "linux-4.17.y"
SRCREV ?= "84d52eb065f1d42e6adb4a32d83eca241a8b39ab"

require linux-stable.inc
