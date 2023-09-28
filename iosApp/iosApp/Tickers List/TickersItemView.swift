//
//  TickersItemView.swift
//  iosApp
//
//  Created by Ivan Khulup on 26.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct TickersItemView: View {
    var item: TickersListItemViewState
    
    var body: some View {
        
        HStack(alignment: .center) {
            VStack(alignment: .leading) {
                Text(item.tickerShortName)
                    .padding(EdgeInsets(top: 2.0, leading: 4.0, bottom: 2.0, trailing: 4.0))
                    .font(.system(size: 11.0, weight: .semibold))
                    .foregroundColor(.TickerSymbolColor)
                    .background(Color.gray.opacity(0.5))
                    .cornerRadius(2.0)
                Spacer().frame(height: 6.0)
                Text(item.tickerFullDisplayName)
                    .font(.system(size: 17.0, weight: .semibold))
                    .lineLimit(1)
            }
            Spacer()
        }.padding().overlay(RoundedRectangle(cornerRadius: 4.0).stroke(.gray.opacity(0.2), lineWidth: 1.0)).scenePadding(.horizontal)
    }
}

struct TickersItemView_Previews: PreviewProvider {
    static var previews: some View {
        TickersItemView(item: TickersListItemViewState(tickerShortName: "AAA", tickerFullDisplayName: "Triple A Name", tickerAssetLocale: "US"))
    }
}
