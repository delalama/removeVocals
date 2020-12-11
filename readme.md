# REMOVE VOCALS API 
This a spring exercise to make a useful Api to remove vocals from audio tracks.

[Reference](https://medium.com/habilelabs/spleeter-a-tensorflow-based-python-library-f084960c3ed8)

The amazing brains behind the algothythm are....
[Python library](https://github.com/deezer/spleeter)

You must first install spleeter and all its dependencies.

[__DEMO_ORIGINAL_AUDIO__](https://drive.google.com/file/d/1iL1GwkGgFsgMScx68UJj9QXtmYmUh1W4/view?usp=sharing)

Sending the file to the spring controller
![](https://github.com/delalama/removeVocals/blob/master/docu/post%20mp3.png)

After processing with Deezer library....
[__PROCESSED_AUDIO__](https://drive.google.com/file/d/1DoPS-PukTXeZhuQKJhAoVzFlC76utEhm/view?usp=sharing)
This library uses tensorflow and is able to split 5 instruments from a track, brilliant. 

![](https://github.com/delalama/removeVocals/blob/master/docu/save%20to%20file.png)
