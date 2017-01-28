package entityLayer;

/**
 * Created by DMITRIUS on 03.01.2017.
 */
public enum Genre {
    ANIME {
        @Override
        public String toWrite() {
            return "аниме";
        }
    },
    BIOGRAPHICAL,
    ACTION {
        @Override
        public String toWrite() {
            return "боевик";
        }
    },
    WESTERN,
    MILITARY,
    DETECTIVE {
        @Override
        public String toWrite() {
            return "детектив";
        }
    },
    CHILDREN,
    DOCUMENTARY,
    DRAMA,
    HISTORICAL,
    COMEDY,
    CONCERT,
    SHORT,
    CRIME,
    ROMANCE,
    MYSTIC,
    MUSIC,
    CARTOON,
    THE_MUSICAL,
    SCIENTIFIC,
    ADVENTURE {
        @Override
        public String toWrite() {
            return "приключение";
        }
    },
    REALITY_SHOW,
    FAMILY,
    SPORT,
    TRILLER,
    HORROR,
    FICTION,
    FILM_NOIR,
    FANTASY {
        @Override
        public String toWrite() {
            return "фэнтези";
        }
    },
    EROTIC;

    public String toWrite() {
        return super.toString();
    }
}
