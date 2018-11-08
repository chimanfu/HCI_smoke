<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description></description>
   <name>textarea_loginblurb</name>
   <tag></tag>
   <elementGuidId>28fc0ec5-32f5-4279-b5e9-82111cd43e5e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>tag</name>
      <type>Main</type>
      <value>textarea</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>name</name>
      <type>Main</type>
      <value>loginblurb</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>id</name>
      <type>Main</type>
      <value>loginblurb</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>rows</name>
      <type>Main</type>
      <value>10</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>cols</name>
      <type>Main</type>
      <value>80</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>&lt;style>
.info,.info p:not(:last-child){margin-bottom:16px}.info{background:#d5e9fa;border:1px solid #1aaaea;padding:8px;color:#24678b;border-radius:4px}.info.email,.info.outage{position:relative;padding:8px 8px 8px 64px}.info:before{position:absolute;left:16px;vertical-align:middle;font-size:28px}.info.email:before{content:'\1F4E5'}.info.outage:before{content:'\1f50c'}.info a{text-decoration:underline;color:inherit!important;font-weight:700}
&lt;/style>
&lt;div class=&quot;info outage&quot;>
    &lt;p>System administrators are planning an outage for standard server maintenance on &lt;strong id=&quot;start_date&quot;>Friday, August 10&lt;/strong>, from &lt;strong id=&quot;start_time&quot;>3:00 pm PDT&lt;/strong> to &lt;strong id=&quot;end_time&quot;>8:00 pm PDT&lt;/strong>&lt;span id=&quot;end_date&quot;>&lt;/span>.&lt;/p>
&lt;/div>
&lt;div class=&quot;info email&quot;>
    &lt;p>After August 10, &lt;strong>system-generated emails will be sent from a new email address (&lt;a href=&quot;mailto:cp-hazard-no-reply@nas.nasa.gov&quot;>cp-hazard-no-reply@nas.nasa.gov&lt;/a>)&lt;/strong>. You may wish to update any Outlook filters accordingly.&lt;/p>
&lt;/div>

&lt;script>
    var startDate = new Date(Date.UTC(2018,7,10,22))
    var endDate = new Date(Date.UTC(2018,7,11,1))

    var days = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
    var months = ['January','February','March','April','May','June','July','August','September','October','November','December'];

    var startDateString = days[startDate.getDay()] + &quot;, &quot; + months[startDate.getMonth()] + &quot; &quot; + startDate.getDate();
    var endDateString = days[endDate.getDay()] + &quot;, &quot; + months[endDate.getMonth()] + &quot; &quot; + endDate.getDate();

    var tzOffset = startDate.getTimezoneOffset();

    var tzString = &quot;&quot;;
    switch(tzOffset) {
        case 240:
            tzString = &quot;EDT&quot;;
            break;
        case 300:
            tzString = &quot;CDT&quot;
            break;
        case 360:
            tzString = &quot;MDT&quot;
            break;
        case 420:
            tzString = &quot;PDT&quot;
            break;
        default:
            tzString = &quot;UTC&quot; + (tzOffset > 0 ? &quot;-&quot; + tzOffset / 60 : &quot;+&quot; + tzOffset / - 60);
    }

    var startTimeString = (startDate.toLocaleString('en-US', { hour: 'numeric', minute: 'numeric', hour12: true }) + &quot; &quot; + tzString).trim()
    var endTimeString = (endDate.toLocaleString('en-US', { hour: 'numeric', minute: 'numeric', hour12: true }) + &quot; &quot; + tzString).trim()

    document.getElementById(&quot;start_date&quot;).innerHTML = startDateString;
    document.getElementById(&quot;start_time&quot;).innerHTML = startTimeString;
    document.getElementById(&quot;end_time&quot;).innerHTML = endTimeString;
    if(startDateString !== endDateString){
        document.getElementById(&quot;end_date&quot;).innerHTML = &quot;&amp;nbsp;on &lt;strong>&quot; + endDateString + &quot;&lt;/strong>&quot;;
    }
&lt;/script>



The Cross-Program Hazard system supports hazards analysis processing including entry, searching, notification, digital signatures, record linking and a variety of other features covered in the overview slides below.&lt;br>&lt;br>

&lt;strong>Sandbox/training instance:&lt;/strong> to experiment with creating and modifying records without affecting production data, head to the CP-Hazard &lt;u>&lt;a href=&quot;https://cxhazard.nasa.gov/training&quot;>sandbox instance.&lt;/a>&lt;/u>&lt;BR />&lt;br>

&lt;strong>Note:&lt;/strong> if your current permissions prevent you from accessing the Program data you require, you can request updates to your account by &lt;u>&lt;a href=&quot;https://nams.nasa.gov/nams/asset/227264/&quot;>logging into NAMS.&lt;/a>&lt;/u> &lt;BR />

&lt;script type=&quot;text/javascript&quot;>
$(document).ready(function () {
    let $lb = $('#login-blurb');
    if ($lb.length !== 0) {
        $.get('announce.cgi', function( data ) {
            $lb.prepend( data );
        });
    }
});
&lt;/script></value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath</name>
      <type>Main</type>
      <value>id(&quot;loginblurb&quot;)</value>
   </webElementProperties>
   <webElementXpaths>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:attributes</name>
      <value>//textarea[@id='loginblurb']</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:idRelative</name>
      <value>//div[@id='bugzilla-body']/div[2]/table/tbody/tr/td[2]/form/dl/dd[6]/p/textarea</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:neighbor</name>
      <value>(.//*[normalize-space(text()) and normalize-space(.)='loginblurb'])[1]/following::textarea[1]</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:neighbor</name>
      <value>(.//*[normalize-space(text()) and normalize-space(.)='Reset'])[6]/preceding::textarea[1]</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:neighbor</name>
      <value>(.//*[normalize-space(text()) and normalize-space(.)='helpguides'])[1]/preceding::textarea[1]</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:position</name>
      <value>//textarea</value>
   </webElementXpaths>
</WebElementEntity>
