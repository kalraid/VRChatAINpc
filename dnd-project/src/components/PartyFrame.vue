<template>
    <div class="PartyFrame">
      <div hidden>
        <div> 사용해야할 URL </div>
        <div> https://github.com/layerssss/paste.js/ </div>
        <div> https://stackblitz.com/edit/angular-f7kcny?file=app/app.component.ts </div>
        <div> https://gist.github.com/sandeepsuvit/a8ba77faebba260455985504be24aef7 </div>
        <div> https://developer.mozilla.org/en-US/docs/Web/API/FileReader </div>
        <div> https://w3c.github.io/clipboard-apis/ </div>
        <div> https://stackoverflow.com/questions/6333814/how-does-the-paste-image-from-clipboard-functionality-work-in-gmail-and-google-c </div>
        <div> https://www.webrtc-experiment.com/getScreenId/ </div>
        <div> https://stackoverflow.com/questions/4912092/using-html5-canvas-javascript-to-take-in-browser-screenshots/6678156#6678156 </div>
        <div> https://github.com/park-chef/joy/issues/8 </div>

        <div> http://html2canvas.hertzen.com/ </div>
        <div> https://developer.mozilla.org/ko/docs/Web/HTML/Canvas/Manipulating_video_using_canvas</div>
        <div> https://www.tensorflow.org/js/tutorials?hl=ko</div>
        <div> https://www.tensorflow.org/js/tutorials/setup?hl=ko</div>
        <div> https://www.tensorflow.org/js/tutorials/training/handwritten_digit_cnn?hl=ko</div>
        <div> https://www.tensorflow.org/js/tutorials/transfer/image_classification?hl=ko</div>
        <div> https://github.com/tensorflow/tfjs-examples</div>
        <div> https://github.com/tensorflow/tfjs-vis</div>
        <div> https://storage.googleapis.com/tfjs-vis/mnist/dist/index.html</div>
        <div> https://js.tensorflow.org/api/latest/?hl=ko#Data</div>
      </div>
      <div>
        <button v-on:click="startCapture">화면 공유 시작</button>
        <button v-on:click="screenCapture">공유된 화면 스크린샷</button>
        <button v-on:click="screenCaptureImages">공유된 화면 스크린샷 to image</button>
        <button v-on:click="getImageForCharacterName">이미지 분석</button>
        <button v-on:click="stopCapture">화면 공유 중지</button>
      </div>
      <div>
        <video id="video" style="width: 50%; height:npm  50%; border: 1px black solid;"/>
        <canvas id="canvas" style="width: 50%; height: 50%; border: 1px black solid;" ></canvas>
      </div>
    </div>
</template>
<script>
/* eslint-disable */
export default {
  name: 'PartyFrame',
  data() {
    return {
      displayMediaOptions : {
        video : {
          cursor : "always"
        },
        audio : false
      },
      video : {
        html : "",
        mediaStream: "",
        recoder : "",
        blob : ""
      }
    }
  },
  methods : {
    keystart: function(event){
      console.log(event);
       console.log(window);
       window.dispatchEvent(new KeyboardEvent('keyup', {code: 'PrintScreen',key:"PrintScreen", keyCode: 44, altKey : 'true'}));
    }, 
    keypress:function(event){
      console.log(event);
      console.log(window);
      //window.dispatchEvent(new KeyboardEvent('keypress', {code: 'KeyR'}));
    },
    startCapture : function(event){
      const vueData = this.$data
      navigator.mediaDevices.getDisplayMedia()
      .then( mediaStream => {
        const video = document.querySelector('video');
        video.srcObject = mediaStream;
        video.onloadedmetadata = e => {
          video.play();
          //video.pause();
          vueData.video.html = video;
          vueData.video.mediaStream = mediaStream;

        };

      })
      .catch( err => console.log(`${err.name}: ${err.message}`));
    
      
    },
    screenCapture : function(event){
      const canvas = document.getElementById("canvas");
      const video = this.$data.video.html;
      canvas.width = video.clientWidth;
      canvas.height = video.clientHeight;
      const ctx = canvas.getContext('2d');
      
      //document.getElementById("screenShotImg").src = canvas.toDataURL();

      window.setInterval(function() {ctx.drawImage(video,0,0,canvas.width, canvas.height)},20);
    },
    stopCapture : function(event){
      this.$data.video.html.pause()
      
    },
    screenCaptureImages : function(event){
      const canvas = document.getElementById("canvas");
      const dataURL = canvas.toDataURL()
      console.log(dataURL)
    },
    getImageForCharacterName : function(event){
      const tf = this.$data.tf

      // Train a simple model:
      const model = tf.sequential();
      model.add(tf.layers.dense({units: 100, activation: 'relu', inputShape: [10]}));
      model.add(tf.layers.dense({units: 1, activation: 'linear'}));
      model.compile({optimizer: 'sgd', loss: 'meanSquaredError'});

      const xs = tf.randomNormal([100, 10]);
      const ys = tf.randomNormal([100, 1]);

      model.fit(xs, ys, {
        epochs: 100,
        callbacks: {
          onEpochEnd: (epoch, log) => console.log(`Epoch ${epoch}: loss = ${log.loss}`)
        }
      });
        
        
    }
  },
  created() {
    this.$data.tf = require('@tensorflow/tfjs');
    
    // Optional Load the binding:
    // Use '@tensorflow/tfjs-node-gpu' if running with GPU.
    require('@tensorflow/tfjs-node');

  },

}
</script>
