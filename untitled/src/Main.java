import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static void main(String[] args)throws Exception  {


        Transcript transcript =new Transcript();
        transcript.setAudioUrl("https://github.com/Yazan-AbdAlmutte-CE/testinggg/raw/main/Thirsty.wav");

        Gson gson =new Gson();
        String jsonReq=gson.toJson(transcript);
        System.out.println("Json req: "+jsonReq);


            HttpRequest Postreq = HttpRequest.newBuilder()
                    .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                    .header("Authorization","d8860e1b9b884c45992988428eef882f")
                   .POST(BodyPublishers.ofString(jsonReq))
                    .build();
            System.out.println("Post req: "+Postreq);

        HttpClient client =HttpClient.newHttpClient();
       HttpResponse<String> response= client.send(Postreq, BodyHandlers.ofString());

        System.out.println("Post Responce "+response.body());






       transcript=gson.fromJson(response.body(),Transcript.class);
       System.out.println(transcript.getId());
        HttpRequest getreq = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"+"/"+transcript.getId()))
                .header("Authorization","d8860e1b9b884c45992988428eef882f")
                .build();
        while (true)
        {
            HttpResponse<String> getresponse= client.send(getreq, BodyHandlers.ofString());
            System.out.println(getresponse.body());
            transcript=gson.fromJson(getresponse.body(),Transcript.class);
            if ("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus()))
            {
                break;
            }
            Thread.sleep(1000);

        }
        System.out.println(transcript.getText());


    }


}