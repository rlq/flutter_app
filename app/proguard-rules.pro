# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# 百度PushSDK
-dontwarn com.baidu.android.pushservice.**
-keep class com.baidu.android.pushservice.**{*; }

# 小米代理推送
-dontwarn com.xiaomi.**
-dontwarn org.apache.thrift.**
-keep class com.xiaomi.**{*; }
-keep class org.apache.thrift.**{*;}

# 魅族代理推送
-dontwarn com.meizu.cloud.**
-keep class com.meizu.cloud.**{*;}

# OPPO代理推送
-dontwarn com.coloros.mcssdk.**
-keep class com.coloros.mcssdk.**{*;}

# VIVO代理推送
-dontwarn com.vivo.push.**
-dontwarn com.vivo.vms.**
-keep class com.vivo.push.**{*; }
-keep class com.vivo.vms.**{*; }

