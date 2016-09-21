### About

## Music Artist Profile Service
	This service will fetch details of an artist from MusicBrainz, Wikipedia and CoverArtArchive

### REST API

## Get profile for an artist
	GET /viaplay/music-artist/details/{mbid}

### Build and Run
	From the root of the project run: mvn spring-boot:run
	
### Stack
	Maven 3
	Java 8
	Springboot
	Jetty
	
### Sample Request
	curl -X GET  "http://localhost:8081/viaplay/music-artist/details/f27ec8db-af05-4f36-916e-3d57f91ecf5e"
	
### Sample Response
	{
  "mbid": "f27ec8db-af05-4f36-916e-3d57f91ecf5e",
  "name": "Michael Jackson",
  "gender": "Male",
  "country": "US",
  "disambiguation": "“King of Pop”",
  "description": "<p><b>Michael Joseph Jackson</b> (August 29, 1958 – June 25, 2009) was an American singer, songwriter, record producer, dancer, and actor. Called the King of Pop, his contributions to music, dance, and fashion along with his publicized personal life made him a global figure in popular culture for over four decades.</p>\n<p>The eighth ............. with $115 million in earnings.</p>\n<p></p>",
  "albums": [
    {
      "id": "500d9b05-68c3-3535-86e3-cf685869efc0",
      "title": "Farewell My Summer Love",
      "imageUrl": "http://coverartarchive.org/release/8172928a-a6c7-4d7c-83c8-5db2a4575094/13404444760.jpg"
    },
    {
      "id": "37906983-1005-36fb-b8e7-3a04687e6f4f",
      "title": "Anthology",
      "imageUrl": "http://coverartarchive.org/release/a7a74484-8c25-47e3-9afc-7de701ad3dde/1619836290.jpg"
    },
    .
    .
    .
    {
      "id": "1516d16c-fad9-413f-99ba-ad1f767c608a",
      "title": "The Motown Years...His Greatest Hits",
      "imageUrl": "http://coverartarchive.org/release/1abad59d-5f52-4b16-9b48-e8beeaf76ec8/8554032338.jpg"
    }
  ]
}