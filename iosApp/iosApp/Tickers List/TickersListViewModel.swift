//
//  TickersListViewModel.swift
//  iosApp
//
//  Created by Ivan Khulup on 16.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class TickersListViewModel: ObservableObject {
    @Published var viewstate: TickerListViewState = TickerListViewState(itemsList: [])
    
    private let repo: DataTickersRepository
    
    init(repo: DataTickersRepository) {
        self.repo = repo
        
        DispatchQueue.main.async {
            repo.loadTickers { [self] data, error in
                if let values = data {
                    viewstate = TickerListViewState(itemsList: values.map { initial in
                        return TickersListItemViewState(tickerShortName: initial.tickerSymbol, tickerFullDisplayName: initial.displayName, tickerAssetLocale: initial.assetLocale)
                    })
                }
            }
            
        }
    }
}
