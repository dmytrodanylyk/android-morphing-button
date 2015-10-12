### Description

Android button which can morph from one shape to another.

<img src="screenshots/intro1.gif" width="380" />

You can easily extend `MorphingButton` to add your own behaviour. Below is example of `LinearProgressButton` which extends `MorphingButton`.

<img src="screenshots/intro2.gif" width="380" />

### Sample code

```java
// sample demonstrate how to morph button to green circle with icon
MorphingButton btnMorph = (MorphingButton) findViewById(R.id.btnMorph);
// inside on click event
MorphingButton.Params circle = MorphingButton.Params.create()
        .duration(500)
        .cornerRadius(dimen(R.dimen.mb_height_56)) // 56 dp
        .width(dimen(R.dimen.mb_height_56)) // 56 dp
        .height(dimen(R.dimen.mb_height_56)) // 56 dp
        .color(color(R.color.green)) // normal state color
        .colorPressed(color(R.color.green_dark)) // pressed state color
        .icon(R.drawable.ic_done); // icon
btnMorph.morph(circle);
```

### Wiki

- Home // TODO
- User Guide // TODO

### Integration

The lib is available on https://jitpack.io.

```
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.dmytrodanylyk:android-morphing-button:98a4986e56' // commit hash
}
```

### License

```
The MIT License (MIT)

Copyright (c) 2015 Danylyk Dmytro

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
