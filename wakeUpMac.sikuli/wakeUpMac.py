# need to export as runnable jar 
print 'wake up my mac machine and type my pin'
pin_field="pin_field.png"
new_PIN_field="new_pin_field.png"
wait(1)
run('caffeinate -u -t 2&')
if exists(new_PIN_field,30):
    click(new_PIN_field)
    type('10051965\n')
elif exists(pin_field,1):
    click(pin_field)
    type('10051965\n')
else:
    type('10051965\n')
run('killall -9 caffeinate')
wait(1)
exit()
#/Users/jcfu/Katalon Studio/HCI_Group/automation/image_jar_lib/SikuliX.app/run 