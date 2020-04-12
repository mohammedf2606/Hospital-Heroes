# Hospital Heroes [![Build Status](https://travis-ci.com/mohammedf2606/Hospital-Heroes.svg?token=kRVvDyzqzVuq179Z3mxV&branch=master)](https://travis-ci.com/mohammedf2606/Hospital-Heroes)

Hospital Heroes is an Android educational game aimed at teaching toddlers about the scanning procedure for the paediatric gamma gastric scan. 

## Getting Started

### Prerequisites

- Android 5 (API 22) - Lollipop
- Resolution: 1024 x 600
- RAM: 1024 MB

### Installing

#### Setting up an emulator

1. In Android Studio, create an [Android Virtual Device (AVD)](https://developer.android.com/studio/run/managing-avds) that the emulator can use to install and run your app.
2. When opening the AVD Manager, create a new hardware profile as per the prerequisites above.

#### Setting up a physical device
1. Connect your device to your development machine with a USB cable. If you developed on Windows, you might need to [install the appropriate USB driver](https://developer.android.com/studio/run/oem-usb) for your device.
2. Perform the following steps to enable **USB debugging** in the **Developer** **options** window:
    1. Open the **Settings** app.
    2. If your device uses Android v8.0 or higher, select **System**. Otherwise, proceed to the next step.
    3. Scroll to the bottom and select **About phone**.
    4. Scroll to the bottom and tap **Build number** seven times.
    5. Return to the previous screen, scroll to the bottom, and tap **Developer options**.
    6. In the **Developer options** window, scroll down to find and enable **USB debugging**.

#### Running the app

1. In Android Studio, select your app from the run/debug configurations drop-down menu in the toolbar.
2. In the toolbar, select the device that you want to run your app on from the target device drop-down menu.
3. Click **Run** ![img](https://developer.android.com/studio/images/buttons/toolbar-run.png).

![Target device drop-down menu.](https://developer.android.com/studio/images/run/deploy-run-app.png)

Android Studio will install the app on your connected device and automatically launch it. 

## Running the Tests

When at the root of the source code repository, open Terminal and run the command below

- `gradle test` for running unit tests
- `gradle connectedAndroidTest` for running instrumentation test

## Built With

Android Studio

## Authors

- Guangzhong Chen
- Fareed Faisal
- Alimahad Mohamed
- Fahim Mohammed
- Manav Parikh
- Syed Qureshi
- Bleon Uka
- Jawad Zeidan

## License

GNU General Public License v2.0. Check LICENSE.md

## Acknowledgements

