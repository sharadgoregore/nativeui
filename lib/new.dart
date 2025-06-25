import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class NativeUi extends StatelessWidget {
  const NativeUi({super.key});

  @override
  Widget build(BuildContext context) {
    const platform = MethodChannel('com.example.nativeui/textview');

    // Method to call native function to display TextView
    Future<void> showNativeTextView() async {
      try {
        await platform.invokeMethod('showTextView');
      } on PlatformException catch (e) {
        print("Failed to show native TextView: '${e.message}'.");
      }
    }
    return Scaffold(appBar: AppBar(),
    body: Center(
      child:  ElevatedButton(
        onPressed: showNativeTextView,
        child: Text('Show Native TextView'),
      ),

    ),
    );
  }
}

