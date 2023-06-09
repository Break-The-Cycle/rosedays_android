package kau.brave.breakthecycle.ui.calendar.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import kau.brave.breakthecycle.domain.model.BraveDate
import kau.brave.breakthecycle.ui.model.DayOfWeek


@Composable
fun RowScope.DateItem(
    day: BraveDate,
    selectedDay: BraveDate,
    menstruationDays: List<BraveDate>,
    childBearingDays: List<BraveDate>,
    ovulationDays: List<BraveDate>,
    setSelectDay: (BraveDate) -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                day.getBackgroundColor(
                    selectedDay,
                    menstruationDays,
                    childBearingDays,
                    ovulationDays
                )
            )
            .clickable { setSelectDay(day) }
            .weight(1f)
            .aspectRatio(1f)
    ) {
        Text(
            text = day.day.toString(),
            modifier = Modifier
                .align(Alignment.Center),
            fontWeight = FontWeight.Bold,
            color = day.getTextColor(
                selectedDay,
                menstruationDays,
                childBearingDays,
                ovulationDays,
                DayOfWeek.getDayOfWeekFromDate(day).color
            ),
        )
    }
}
