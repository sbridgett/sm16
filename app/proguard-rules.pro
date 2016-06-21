# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\HP\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Setting for the batch push notification service:

# SJB - The firebase quickstart demo doesn't have any rules in its proguard-rules.pro file:
 # https://github.com/firebase/quickstart-android/blob/master/messaging/app/proguard-rules.pro
# so commenting out all the rules below which were for catch:

#-keep class com.batch.** {
#  *;
#}

## The following may have changed:
#-keep class com.google.android.gms.** {
#  *;
#}

#-dontwarn com.batch.android.mediation.**

#-dontwarn com.batch.android.BatchPushService