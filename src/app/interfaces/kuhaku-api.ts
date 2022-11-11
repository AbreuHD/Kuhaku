export interface Home {
  adult: boolean;
  backdrop_path?: string;
  genre_ids: any[];
  id: number;
  original_language: string;
  original_title: string;
  overview: string;
  popularity: number;
  poster_path?: string;
  release_date: string;
  title: string;
  video: string;
  vote_average: number;
  vote_count: number;
  cuevana: any[];
}

export interface MovieDetails {
  adult: boolean;
  backdrop_path: string;
  genre_ids: any[];
  id: number;
  original_language: string;
  original_title: string;
  overview: string;
  popularity: number;
  poster_path: string;
  release_date: string;
  title: string;
  video: string;
  vote_average: number;
  vote_count: number;
  movieLinks: MovieLink[];
}

interface MovieLink {
  title: string;
  photo: string;
  link: string;
  age: string;
  confirmed: boolean;
  tmdbId: string;
}
