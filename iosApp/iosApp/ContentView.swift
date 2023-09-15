import SwiftUI
import shared

struct ContentView: View {
    

    private let component: DataTickersRepository
    @State var response: [ModelsTicker]
    
    init(component: IOSSharedComponent) {
        self.component = component.repository
        self.response = []
    }
    
	var body: some View {
        VStack {
            Text("loaded \(response.count) items")
            Button("Load") {
                Task {
                    response = try await component.getAllCachedStocks()
                }
            }
        }

    }
}

//struct ContentView_Previews: PreviewProvider {
//	static var previews: some View {
//		ContentView()
//	}
//}
