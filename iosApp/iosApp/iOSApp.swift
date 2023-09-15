import SwiftUI
import shared

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            let component = IOSSharedComponent.companion.create();
            ContentView(component: component)
		}
	}
}
