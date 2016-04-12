import entities.Album
import entities.Song
import org.apache.poi.hssf.usermodel.HSSFWorkbook

def slurper = new XmlSlurper(false, false, true);
slurper.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false)
slurper.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

def libraryFile = slurper.parse("C:\\dev\\workspaces\\library-ws\\library\\ItunesLibrary.xml")

def songs = libraryFile.dict.dict.dict

List songList = new ArrayList();

Iterator songIt = songs.iterator()
while(songIt.hasNext()){
    Song track = new Song()
    def song = songIt.next()
    def keys = song.childNodes()
    Iterator keysIt = keys.iterator()
    while(keysIt.hasNext()){
        def key = keysIt.next()
        String keyString = "${key}"

        if(keyString.equals('Artist')) {
            def artist = keysIt.next()
            String artistString = "${artist}"
            track.setArtist(artistString)
        }

        if(keyString.equals('Album Artist')) {
            def albumArtist = keysIt.next()
            String albumArtistString = "${albumArtist}"
            track.setAlbumArtist(albumArtistString)
        }

        if(keyString.equals('Album')) {
            def albumName = keysIt.next()
            String albumString = "${albumName}"
            track.setAlbum(albumString)
        }

        if(keyString.equals('Name')) {
            def trackName = keysIt.next()
            String trackNameString = "${trackName}"
            track.setName(trackNameString)
        }

        if(keyString.equals('Genre')) {
            def genre = keysIt.next()
            String genreString = "${genre}"
            track.setGenre(genreString)
        }

        if(keyString.equals('Year')) {
            def year = keysIt.next()
            int yearInt = "${year}".toInteger()
            track.setYear(yearInt)
        }

        if(keyString.equals('Album Rating')) {
            def albumRating = keysIt.next()
            int albumRatingInt = "${albumRating}".toInteger()
            track.setAlbumRating(albumRatingInt)
        }

        if(keyString.equals('Track ID')) {
            def trackId = keysIt.next()
            int trackIdInt = "${trackId}".toInteger()
            track.setTrackId(trackIdInt)
        }

        if(keyString.equals('Rating')) {
            def rating = keysIt.next()
            int ratingInt = "${rating}".toInteger()
            track.setRating(ratingInt)
            if(ratingInt!=0)
                track.setRatingSet(true);
        }

        if(keyString.equals('Size')) {
            def size = keysIt.next()
            int sizeInt = "${size}".toInteger()
            track.setSize(sizeInt)
        }

        if(keyString.equals('Play Count')) {
            def playCount = keysIt.next()
            int playCountInt = "${playCount}".toInteger()
            track.setPlayCount(playCountInt)
        }

        if(keyString.equals('Total Time')) {
            def totalTime = keysIt.next()
            int totalTimeInt = "${totalTime}".toInteger()
            track.setTotalTime(totalTimeInt)
        }

    }
    songList.add(track)
    //println "${albums.toString()}"
}
songList = songList.sort()
println("DONE")

int rowNum = 0;
new HSSFWorkbook().with { workbook ->
    createSheet( 'Output' ).with { sheet ->

        //Header Row
        createRow( rowNum ).with { row ->
            int colNum=0
            createCell( colNum ).with { cell ->
                setCellValue("Artist")
            }
            colNum++
            createCell( colNum ).with { cell ->
                setCellValue("Album")
            }
            colNum++
            createCell( colNum ).with { cell ->
                setCellValue("Year")
            }
            colNum++
            createCell( colNum ).with { cell ->
                setCellValue("Rating/100")
            }
            colNum++
            createCell( colNum ).with { cell ->
                setCellValue("Total Size (MB)")
            }
            colNum++
            createCell( colNum ).with { cell ->
                setCellValue("Tracks")
            }
            colNum++
            createCell( colNum ).with { cell ->
                setCellValue("Length (min)")
            }
            colNum++
            createCell( colNum ).with { cell ->
                setCellValue("Play Count")
            }
            rowNum++;
        }

        Iterator albumIt = albums.iterator()
        while(albumIt.hasNext()){
            Album album = albumIt.next()
            createRow( rowNum ).with { row ->
                int colNum=0
                createCell( colNum ).with { cell ->
                    setCellValue(album.getAlbumArtist())
                }
                colNum++;
                createCell( colNum ).with { cell ->
                    setCellValue(album.getAlbum())
                }
                colNum++;
                createCell( colNum ).with { cell ->
                    setCellValue(album.getYear())
                }
                colNum++;
                createCell( colNum ).with { cell ->
                    setCellValue(album.getTotalRating())
                }
                colNum++;
                createCell( colNum ).with { cell ->
                    setCellValue(album.getTotalSize())
                }
                colNum++;
                createCell( colNum ).with { cell ->
                    setCellValue(album.getTotalTracks())
                }
                colNum++;
                createCell( colNum ).with { cell ->
                    setCellValue(album.getTotalTime())
                }
                colNum++;
                createCell( colNum ).with { cell ->
                    setCellValue(album.getTotalPlayCount())
                }
            }
            rowNum++;
        }

        (0..7).each{ colNumber-> sheet.set(colNumber)}

        new File( 'C:\\dev\\workspaces\\library-ws\\library\\albumsTest.xls' ).withOutputStream { os ->
            write( os )
        }
    }
}

