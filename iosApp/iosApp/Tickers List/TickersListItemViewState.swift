//
//  TickersListItemViewState.swift
//  iosApp
//
//  Created by Ivan Khulup on 26.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

struct TickersListItemViewState {
    let tickerShortName: String
    let tickerFullDisplayName: String
    let tickerAssetLocale: String
}

struct TickerListViewState {
    let itemsList: [TickersListItemViewState]
}
