# ReceiveDatafromYoutubeApp
 
This repository contains how you can easliy get data from other apps when we click on share button to our app. 

To see th full tutorial of this video refer this link -> https://youtu.be/wr7IeLD3Ka0

This is only for youtube app : 

1. When you click on share button on any video in youtube app then this app will be shown and accepts the link of that particular video

2. Also you can fetch the thumbnail of that video through the Id that will be fetched from a "regex" code : 

a.  


var link="https://img.youtube.com/vi/${getLinkFromURL(intent.getStringExtra(Intent.EXTRA_TEXT))}/maxresdefault.jpg"


b.
 
 fun getIdFromURL(url : String?) : String?{
 
        val regex = "(?<=youtu.be/|watch\\? v=|/videos/|embed\\/)[^#\\&\\?]*"
        
        var pattern=Pattern.compile(regex,Pattern.CASE_INSENSITIVE)
        
        var matcher=pattern.matcher(url.toString())
        
        var videoId = ""
        
        if(matcher.find()){
        
            videoId=matcher.group()
            
        }
        
        return videoId
        
    }

Hope it helps you.
