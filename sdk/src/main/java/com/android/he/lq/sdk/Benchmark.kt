package com.android.he.lq.sdk

/*
    简介
    https://developer.android.com/studio/profile/benchmark

    Benchmark 在AS3.5+版本上使用
    作用是什么——测试代码性能
        RecycleView, inflate View, DB queries...
    怎么用
       1. project_root/module_dir/build.gradle
        dependencies {
            androidTestImplementation "androidx.benchmark:benchmark-junit4:1.0.0-alpha04"
        }
       2. 强制debug，project_root/module_dir/src/androidTest/AndroidManifest.xml
       <application
            android:debuggable="false"
            tools:ignore="HardcodedDebugMode"
            tools:replace="android:debuggable"/>
       3. 测试用例中添加实例
        @RunWith(AndroidJUnit4::class)
        class MyBenchmark {
            @get:Rule
            val benchmarkRule = BenchmarkRule()

            @Test
            fun benchmarkSomeWork() = benchmarkRule.measureRepeated {
                doSomeWork()
            }
        }

        5. 运行标准检查程序
        输入命令./gradlew benchmark:connectedCheck

    会增加多大的包大小

    Jetpack还有什么好东西

 */

class Benchmark

