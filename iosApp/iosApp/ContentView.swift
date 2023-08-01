import SwiftUI
import shared

struct ContentView: View {

    @State var response = "response"
    
	var body: some View {
        VStack {
            Text(response)
            Button("Load") {
                Task {
                    response = try await Greeting().greet()
                }
            }
        }

    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
