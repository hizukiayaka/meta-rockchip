FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_tinker-rk3288 = " file://0001-configs-tinker-rk3288-disable-CONFIG_SPL_I2C_SUPPORT.patch"

do_compile_append_rk3288 () {
	# copy to default search path
	if [ ${SPL_BINARY} ]; then
		cp ${B}/spl/${SPL_BINARY} ${B}/
	fi
}
