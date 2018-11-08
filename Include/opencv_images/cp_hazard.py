performance_TAB=Pattern("performance_TAB.png").similar(0.75)
Summary_TAB=Pattern("Summary_TAB.png").similar(0.75)
clear_button="clear_button.png"
stop_button="stop_button.png"
WhatsNew_TAB="WhatsNew_TAB.png"
close_button="close_button.png"

smartcard_login_button="smartcard_login_button.png"
acceptCert_ok_button="acceptCert_ok_button.png"
cp_hazard_logo="cp_hazard_logo.png"
sanityCheck_link="sanityCheck_link.png"
vpn_url="https://ames-vpn.arc.nasa.gov/dana/home/index.cgi"
pulseAppLauncher_start_button="pulseAppLauncher_start_button.png"
pulseAppLauncher_allow_button="pulseAppLauncher_allow_button.png"
restore_pages_cancel_button=Pattern("restore_pages_cancel_button.png").targetOffset(145,-6)
pdf_downloadedFile_icon_old=Pattern("pdf_downloadedFile_icon_old.png").similar(0.66)
pdf_downloadedFile_icon="pdf_downloadedFile_icon.png"

Region(1,770,167,129)
Region(3,726,353,172)
Region(1159,754,281,147)
Region(805,0,635,235)
Region(809,0,631,297)
default_downloadedFile_icon="default_downloadedFile_icon.png"
chrome_downloadedFile_showAll_cancel_button=Pattern("chrome_downloadedFile_showAll_cancel_button.png").targetOffset(48,2)

KatalonNetworkConnections_deny_button="KatalonNetworkConnections_deny_button.png"
pin_field="pin_field.png"

new_pin_field="new_pin_field.png"
pin_field_activID="pin_field_activID.png"
disconnect="disconnect.png"

securePulseVPN_connected_icon="securePulseVPN_connected_icon.png"
vpn_selection="vpn_selection.png"
continue_the_session="continue_the_session.png"

# cisco anyconnect
AnyConnect_connect="AnyConnect_connect.png"
AnyConnect_Accept="AnyConnect_Accept.png"
AnyConnect_Up_icon="AnyConnect_Up_icon.png"
#run ('open "/Applications/Cisco/Cisco AnyConnect Secure Mobility Client.app" &')
if exists(AnyConnect_connect,20):
    click(AnyConnect_connect)

if exists(pin_field_activID,5):
    type('10051965\n')
if exists(AnyConnect_Accept,8):
    click(AnyConnect_Accept)

if exists(AnyConnect_Up_icon,10):
    print 'AnyConnect is Up'
else:
    print 'AnyConnect may not be Up'
exit()
# cisco anyconnect


wait(10)
#type('abc\n\n')
run('caffeinate -u -t 2&')
if exists(pin_field,20):
    click(pin_field)
    type('10051965\n')
exit()


