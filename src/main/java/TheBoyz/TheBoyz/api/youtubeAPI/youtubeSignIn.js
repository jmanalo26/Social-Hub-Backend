    <script src="https://apis.google.com/js/api.js"></script>
    # https://www.youtube.com/embed/
    <script>
  function authenticate() {
    return gapi.auth2.getAuthInstance()
        .signIn({scope: "https://www.googleapis.com/auth/youtube.readonly"})
        .then(function() { console.log("Sign-in successful"); },
              function(err) { console.error("Error signing in", err); });
  }
  function loadClient() {
    gapi.client.setApiKey("AIzaSyBsgGsLLQOFP4WZvVKUJqfuWPthPra71zs");
    return gapi.client.load("https://www.googleapis.com/discovery/v1/apis/youtube/v3/rest")
        .then(function() { console.log("GAPI client loaded for API"); },
              function(err) { console.error("Error loading GAPI client for API", err); });
  }
  function execute() {
      return gapi.client.youtube.search.list({
      "part": [
        "snippet"
      ],
      "forMine": true,
      "maxResults": 25,
      "type": [
        "video"
      ]
    })
        .then(function(response) {
                // Handle the results here (response.result has the parsed body).
                console.log("Response", response);
                addElements(response.result.items.length);
                getVideos(response.result.items);

              },
              function(err) { console.error("Execute error", err); });
  }
  function addElements(length) {
    for(var i = 0; i < length; i++) {
        document.getElementById('videoContainer').innerHTML = '<div class = "col-6"> <center><iframe style = "min-width: 400;" width = "400" height = "300" id = "divVid' + i.toString() + '"></iframe></center> </div>';
     }
  }
  function getVideos(videos) {
  var youtubeString = "https://www.youtube.com/embed/"
  var videoArr = {}
    for(int i = 0; i < videos.length; i++) {
        document.getElementById('divVid' + i.toString()).src = youtubeString + videos[i].id.videoId;
    }
  }
  gapi.load("client:auth2", function() {
    gapi.auth2.init({client_id: "665124826397-55241tfc755m03bp83d5io7kef9irbo2.apps.googleusercontent.com"});
  });
</script>