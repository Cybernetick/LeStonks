//
//  TickersListView.swift
//  iosApp
//
//  Created by Ivan Khulup on 16.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TickersListView: View {
    
    @ObservedObject private var viewModel: TickersListViewModel
    
    init() {
        let component = IOSSharedComponent.companion.create()
        self.viewModel = TickersListViewModel(repo: component.repository)
    }
    
    var body: some View {
        List(viewModel.viewstate.itemsList, id: \.tickerShortName.hashValue) { item in
            TickersItemView(item: item).listRowSeparator(.hidden, edges: .all).listRowInsets(EdgeInsets(top: 3.0, leading: 0.0, bottom: 3.0, trailing: 0.0))
        }.listStyle(PlainListStyle())
    }
}

struct TickersListView_Previews: PreviewProvider {
    static var previews: some View {
        let items = [TickersListItemViewState(tickerShortName: "AAA", tickerFullDisplayName: "Triple A Name", tickerAssetLocale: "US"),
                     TickersListItemViewState(tickerShortName: "BBB", tickerFullDisplayName: "Triple B Name", tickerAssetLocale: "US"),
                     TickersListItemViewState(tickerShortName: "CCC", tickerFullDisplayName: "Triple C Name", tickerAssetLocale: "US"),
                     TickersListItemViewState(tickerShortName: "DDD", tickerFullDisplayName: "Triple D Name", tickerAssetLocale: "US")]
        List(items, id: \.tickerShortName.hashValue) { item in
            TickersItemView(item: item).listRowSeparator(.hidden, edges: .all)
        }
    }
}
