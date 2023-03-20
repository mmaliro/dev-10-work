import React, { useState } from 'react';

function Movie(props) {
  const { id, title, year, onDelete } = props;

  function handleDelete() {
    onDelete(id);
  }

  return (
    <div>
      <h3>{title}</h3>
      <p>Released: {year}</p>
      <button onClick={handleDelete}>Delete</button>
    </div>
  );
}

function Movies() {
  const [movies, setMovies] = useState([
    { id: 1, title: 'The Shawshank Redemption', year: 1994 },
    { id: 2, title: 'The Godfather', year: 1972 },
    { id: 3, title: 'The Dark Knight', year: 2008 },
  ]);

  function deleteMovie(id) {
    setMovies(movies.filter(movie => movie.id !== id));
  }

  function addMovie() {
    const nextId = movies.length > 0 ? Math.max(...movies.map(m => m.id)) + 1 : 1;
    const newMovie = { id: nextId, title: 'New Movie', year: 2023 };
    setMovies([...movies, newMovie]);
  }

  return (
    <div>
      <h2>Movies</h2>
      <button onClick={addMovie}>Add Movie</button>
      {movies.map(movie => (
        <Movie
          key={movie.id}
          id={movie.id}
          title={movie.title}
          year={movie.year}
          onDelete={deleteMovie}
        />
      ))}
    </div>
  );
}

export default Movies;



