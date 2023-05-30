import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    
    var body: some View {
        List(viewModel.movies, id: \.self) { movie in
            Text(movie.movieName)
        }
    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var movies: [Movie] = []
        let appModule = AppModule()
        init() {
                DispatchQueue.main.async {
                    self.appModule.movieClient.getMovies{ movies, error in
                        if let movies = movies {
                                self.movies = movies
                        } else {
                            self.movies = []
                        }
                    }
                }
            }
    }
}
