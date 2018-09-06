smartcard_login_button="smartcard_login_button.png"
acceptCert_ok_button="acceptCert_ok_button.png"
cp_hazard_logo="cp_hazard_logo.png"
sanityCheck_link="sanityCheck_link.png"
vpn_url="https://ames-vpn.arc.nasa.gov/dana/home/index.cgi"
pulseAppLauncher_start_button="pulseAppLauncher_start_button.png"
pulseAppLauncher_allow_button="pulseAppLauncher_allow_button.png"
restore_pages_cancel_button=Pattern("restore_pages_cancel_button.png").targetOffset(145,-6)
pdf_downloadedFile_icon=Pattern("pdf_downloadedFile_icon.png").similar(0.66)
default_downloadedFile_icon="default_downloadedFile_icon.png"
chrome_downloadedFile_showAll_cancel_button=Pattern("chrome_downloadedFile_showAll_cancel_button.png").targetOffset(48,2)

KatalonNetworkConnections_deny_button="KatalonNetworkConnections_deny_button.png"
click(KatalonNetworkConnections_deny_button)
exit()

wait(pulseAppLauncher_start_button,20)
doubleClick(pulseAppLauncher_start_button)
type("\n")
#doubleClick(pulseAppLauncher_allow_button)


//div[@class = 'digItFieldContainer']/input[1]
