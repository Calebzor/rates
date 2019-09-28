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

## Retrofit (from their docs)
# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions
# Retrofit uses Okio under the hood, rules from Okio docs:
-dontwarn okio.**
-dontwarn javax.annotation.**

# https://github.com/google/dagger/issues/645#issuecomment-296851566
-dontwarn com.google.errorprone.annotations.*

# https://github.com/google/dagger/issues/645#issuecomment-296851566
-dontwarn com.google.errorprone.annotations.*

-keepclassmembers class hu.tvarga.**ApiObject {
    !static !transient <fields>;
}

-keepclassmembers enum hu.tvarga.**ApiObject { *; }

-keep class okhttp3.internal.platform.** { *; }
-dontwarn okhttp3.internal.platform.**


#no obfuscation needed here
-keep class com.** { *; }
-keep class android.** { *; }
-keep class org.** { *; }
-keep class java.** { *; }
-keep public class **.R { public *; }
-keep public class **.R$* { public *; }

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * { *; }

-dontwarn javax.inject.Inject
-dontwarn javax.annotation.Nullable

-keep class **.Finalizer

#Keep all annotations
-keepattributes **

-keepclassmembers class * {
    @javax.annotation.** *;
}

# Dagger
-keepclassmembers,allowobfuscation class * {
    @javax.inject.* *;
}
-keep class javax.inject.* { *; }


# Butterknife
-keep @interface butterknife.*

-keepclasseswithmembers class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembers class * {
    @butterknife.* <methods>;
}

-keepclasseswithmembers class * {
    @butterknife.On* <methods>;
}


-keep class **$$ViewInjector {
    public static void inject(...);
    public static void reset(...);
}

-keep class **$$ViewBinder {
    public static void bind(...);
    public static void unbind(...);
}
